package com.xds.recharge.service;

import com.xds.recharge.dto.LatitudeAndLongitudeDto;
import com.xds.recharge.dto.LatitudeAndLongitudeResponsDto;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huangjinhao
 */
public interface CheckLocationService {

    LatitudeAndLongitudeResponsDto checkLocation(LatitudeAndLongitudeDto dto,HttpServletRequest request);
}
