package it.verding.edo.web;

import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.converter.RooConversionService;

/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
	}
	/*
	public Converter<String, Comune> getStringToComuneConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, it.verding.edo.domain.Comune>() {
            public it.verding.edo.domain.Comune convert(String id) {
                return getObject().convert(getObject().convert(id, ObjectId.class), Comune.class);
            }
        };
    }
	 */
}
