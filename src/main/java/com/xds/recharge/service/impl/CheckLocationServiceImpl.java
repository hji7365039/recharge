package com.xds.recharge.service.impl;

import com.xds.recharge.dto.LatitudeAndLongitudeDto;
import com.xds.recharge.dto.LatitudeAndLongitudeResponsDto;
import com.xds.recharge.service.CheckLocationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


/**
 * @author huangjinhao
 */
@Service
public class CheckLocationServiceImpl implements CheckLocationService {

    @Value("${location.min_lat}")
    private String min_lat;

    @Value("${location.max_lat}")
    private String max_lat;

    @Value("${location.min_lng}")
    private String min_lng;

    @Value("${location.max_lng}")
    private String max_lng;

    /**
     * 校验位置
     * @return  lat 南北    lng  东西
     */
    @Override
    public LatitudeAndLongitudeResponsDto checkLocation(LatitudeAndLongitudeDto dto,HttpServletRequest request){
        LatitudeAndLongitudeResponsDto responsDto= new LatitudeAndLongitudeResponsDto();

        //始终返回true，在区域外也可以答题，但是没有奖励
        responsDto.setOnSide(true);
        responsDto.setCentent("在蒋村街道范围内才能参加活动哦！");

        if(dto.getLat()==null||dto.getLng()==null){
            return  responsDto;
        }

        String lat=dto.getLat();
        String lng=dto.getLng();

        double dLat=Double.parseDouble(lat);
        double dLng=Double.parseDouble(lng);

        System.out.println(dLat);
        System.out.println(dLng);

        double minLat=Double.parseDouble(min_lat);
        double maxLat=Double.parseDouble(max_lat);

        double minLng=Double.parseDouble(min_lng);
        double maxLng=Double.parseDouble(max_lng);

        if(dLat >= minLat
                &&dLat<=maxLat
                &&dLng>=minLng
                &&minLng<=maxLng){
            responsDto.setOnSide(true);
            request.getSession().setAttribute("inSide","true");
        }else{
            request.getSession().setAttribute("inSide","false");
        }



        return  responsDto;
    }
}
