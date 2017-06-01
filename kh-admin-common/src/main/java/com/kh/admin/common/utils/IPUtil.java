package com.kh.admin.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;


public class IPUtil {

    /**
     * 获取Ip地址，先取X-Forwarded-For地址，如果为空， <br>
     * 取Proxy-Client-IP，如果为空，再取<br>
     * WL-Proxy-Client-IP，如果为空，再取request.getRemoteAddr() <br>
     * 注意：如果以上任何一种方式获取到的ip中有, 逗号分隔出的多个IP地址，则取第一个合法的IP地址（非unknown的地址)
     *
     * @param request
     * @return
     */
    public static String getRemotIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || "".equals(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || "".equals(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || "".equals(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip != null && !"".equals(ip)) {
            String[] ips = ip.split(",");
            for (int i = 0; i < ips.length; i++) {
                if (ips[i] != null && !"".equals(ips[i])
                        && !"unknown".equalsIgnoreCase(ips[i])) {
                    ip = ips[i];
                    break;
                }

            }
        }
        return ip;
    }

    /**
     * 判断targetIp和网段是否匹配
     *
     * @param targetIp
     * @param network  IP/Subnet子网切割表示法
     * @return
     */

    public static boolean match(String targetIp, String network) {
        // 以下ip采用int(32位)表示
        int ip = 0;
        String targetIps[] = targetIp.split("\\.", 4);
        for (int i = 0; i < 4; ++i) {
            ip = Integer.valueOf(targetIps[i]) << (24 - 8 * i) | ip;
        }
        String networkIpSubnet[] = network.split("/");
        String networkIps[] = networkIpSubnet[0].split("\\.", 4);
        int networkSubnet = Integer.valueOf(networkIpSubnet[1]);
        int networkIp = 0;
        for (int i = 0; i < 4; ++i) {
            networkIp = Integer.valueOf(networkIps[i]) << (24 - 8 * i) | networkIp;
        }
        int mask = 0xFFFFFFFF;
        mask = mask << (32 - networkSubnet);
        return (ip & mask) == (networkIp & mask);
    }

    /**
     * 将127.0.0.1形式的IP地址转换成十进制整数，这里没有进行任何错误处理
     *
     * @param strIp
     * @return
     */
    public static long ipToLong(String strIp) {
        long[] ip = new long[4];
        //先找到IP地址字符串中.的位置
        int position1 = strIp.indexOf(".");
        int position2 = strIp.indexOf(".", position1 + 1);
        int position3 = strIp.indexOf(".", position2 + 1);
        //将每个.之间的字符串转换成整型
        ip[0] = Long.parseLong(strIp.substring(0, position1));
        ip[1] = Long.parseLong(strIp.substring(position1 + 1, position2));
        ip[2] = Long.parseLong(strIp.substring(position2 + 1, position3));
        ip[3] = Long.parseLong(strIp.substring(position3 + 1));
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
    }


    public static String getRealIp() {
        String localip = null;// 本地IP，如果没有配置外网IP则返回它
        String netip = null;// 外网IP

        try {
            Enumeration<NetworkInterface> netInterfaces =
                    NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            boolean finded = false;// 是否找到外网IP

            while (netInterfaces.hasMoreElements() && !finded) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> address = ni.getInetAddresses();
                while (address.hasMoreElements()) {
                    ip = address.nextElement();
                    if (!ip.isSiteLocalAddress()
                            && !ip.isLoopbackAddress()
                            && !ip.getHostAddress().contains(":")) {// 外网IP
                        netip = ip.getHostAddress();
                        finded = true;
                        break;
                    } else if (ip.isSiteLocalAddress()
                            && !ip.isLoopbackAddress()
                            && !ip.getHostAddress().contains(":")) {// 内网IP
                        localip = ip.getHostAddress();
                    }
                }
            }

            if (netip != null && !"".equals(netip)) {
                return netip;
            } else {
                return localip;
            }

        } catch (SocketException e) {
            return null;
        }
    }
}
