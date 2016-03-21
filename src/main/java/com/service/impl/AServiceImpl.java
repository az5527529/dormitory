package com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.A;
import com.service.AService;
import com.service.common.BaseService;
import com.service.impl.common.BaseServiceImpl;

@Service("aService")
public class AServiceImpl extends BaseServiceImpl<A> implements AService {
}
