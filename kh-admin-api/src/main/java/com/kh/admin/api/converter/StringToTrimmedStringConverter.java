package com.kh.admin.api.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

public class StringToTrimmedStringConverter implements Converter<String, String> {

	@Override
	public String convert(String source) {
		return StringUtils.isBlank(source) ? null : StringUtils.trim(source);
	}

}
