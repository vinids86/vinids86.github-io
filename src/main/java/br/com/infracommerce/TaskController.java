package br.com.infracommerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * Created by vinicius on 21/02/17.
 */
@RestController
public class TaskController {

    private static final Logger log = LoggerFactory.getLogger(KanboardApplication.class);

    @Autowired
    TaskServiceImpl taskService;

    @RequestMapping("/moveTaskPosition")
    public String moveTaskPosition() {
        try {
            taskService.moveTaskPosition();
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage());
        }
        return null;
    }

}
