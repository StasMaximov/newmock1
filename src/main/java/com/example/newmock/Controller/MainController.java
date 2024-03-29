package com.example.newmock.Controller;

import com.example.newmock.Model.RequestDTO;
import com.example.newmock.Model.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController

public class MainController {

    private Logger log = LoggerFactory.getLogger(MainController.class);

    ObjectMapper mapper = new ObjectMapper();

    @PostMapping(
            value = "/info/postBalances",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Object postBalances(@RequestBody RequestDTO requestDTO) {
        try {
            String clientId = requestDTO.getClientId();
            char firstDigit = clientId.charAt(0);
            BigDecimal maxLimit;
            String b=toString();
            String RqUID = requestDTO.getRqUID();

 //           String responce = "{\n" +
//                    "    \"rqUID\": \"58dgtf565j8547f64ke7\",\n" +
 //                   "    \"clientId\": \"6050000000000000000\",\n" +
 //                   "    \"account\": \"30500000000000000001\",\n" +
  //                  "    \"currency\": \"RUB\",\n" +
 //                   "    \"balance\": 7777777,\n" +
 //                   "    \"maxLimit\": 1\n" +
  //                  "}"
            int a=0;

            if (firstDigit == '8') {
                maxLimit = new BigDecimal(2000);
                a=2000;
                b="US";
            } else if (firstDigit == '9') {
                maxLimit = new BigDecimal(1000);
                a=1000;
                b="EU";
            } else {
                maxLimit = new BigDecimal(10000);
                a=10000;
                b="RUB";
            }
            int balance1 = 0 + (int) ( Math.random() * a );

            ResponseDTO responseDTO = new ResponseDTO();


            responseDTO.setRqUID(RqUID);
            responseDTO.setClientId(clientId);
            responseDTO.setAccount(requestDTO.getAccount());
            responseDTO.setCurrency(b);
            responseDTO.setBalance(balance1);
            responseDTO.setMaxLimit(maxLimit);

            log.error("*********** RequestDTO ***********" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestDTO));
            log.error("*********** ResponseDTO ***********" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseDTO));

            return responseDTO;

//            return responce;

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}