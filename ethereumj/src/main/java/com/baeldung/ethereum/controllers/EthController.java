package com.baeldung.ethereum.controllers;

import com.baeldung.ethereum.Constants;
import com.baeldung.ethereum.beans.EthBean;
import com.baeldung.ethereum.transfer.EthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

@RestController
public class EthController {

    @Autowired
    EthBean ethBean;
    @Autowired
    private ServletContext servletContext;
    private Logger l = LoggerFactory.getLogger(EthController.class);

    @RequestMapping(Constants.ENDPOINT_ONE)
    public EthResponse getBestBlock() {
        l.debug("Request received - fetching best block.");
        EthResponse r = new EthResponse();
        r.setResponse(ethBean.getBestBlock().toString());
        return r;
    }

    @RequestMapping(Constants.ENDPOINT_TWO)
    public EthResponse getTotalDifficulty() {
        l.debug("Request received - calculating total difficulty.");
        EthResponse r = new EthResponse();
        r.setResponse(ethBean.getTotalDifficulty().toString());
        return r;
    }

    @PostConstruct
    public void showIt() {
        l.debug(servletContext.getContextPath());
    }
}
