package br.com.infracommerce;

import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * Created by vinicius on 20/02/17.
 */
public interface TaskService {

    void moveTaskPosition() throws UnsupportedEncodingException;
}
