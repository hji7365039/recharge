package com.xds.recharge.service;

import com.xds.recharge.dto.HandInAnswerDto;
import com.xds.recharge.dto.HandInAnswerResponseDto;
import com.xds.recharge.model.Topic;

import java.util.List;

public interface AnswerService {


    List<Topic> getAnswer();

    HandInAnswerResponseDto handInAnswer(HandInAnswerDto dto);


}
