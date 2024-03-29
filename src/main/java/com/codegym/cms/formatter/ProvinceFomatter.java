package com.codegym.cms.formatter;

import com.codegym.cms.model.Province;
import com.codegym.cms.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ProvinceFomatter implements Formatter<Province> {
    private ProvinceService provinceService;
    @Autowired
    public ProvinceFomatter(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }
    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        return provinceService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Province object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
