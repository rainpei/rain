/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.github.rain.mc.handler;

import com.github.rain.common.util.template.MobileMsgTemplate;

/**
 * @author lengleng
 * @date 2018/1/16
 * 抽象hander
 */
public abstract class AbstractMessageHandler implements SmsMessageHandler {

    /**
     * 执行入口
     *
     * @param mobileMsgTemplate 信息
     */
    @Override
    public void execute(MobileMsgTemplate mobileMsgTemplate) {
        check(mobileMsgTemplate);
        if (!process(mobileMsgTemplate)) {
            fail(mobileMsgTemplate);
        }
    }

    /**
     * 数据校验
     *
     * @param mobileMsgTemplate 信息
     */
    @Override
    public abstract void check(MobileMsgTemplate mobileMsgTemplate);

    /**
     * 业务处理
     *
     * @param mobileMsgTemplate 信息
     * @return boolean
     */
    @Override
    public abstract boolean process(MobileMsgTemplate mobileMsgTemplate);

    /**
     * 失败处理
     *
     * @param mobileMsgTemplate 信息
     */
    @Override
    public abstract void fail(MobileMsgTemplate mobileMsgTemplate);
}
