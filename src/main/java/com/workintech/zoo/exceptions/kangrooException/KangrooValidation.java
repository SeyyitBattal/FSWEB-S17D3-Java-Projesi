package com.workintech.zoo.exceptions.kangrooException;

import com.workintech.zoo.entity.Kangaroo;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class KangrooValidation {

    public static void isIDnotValid(int id) {
        if (id <= 0) throw new KangrooException(id +
                " this ID isn't valid", HttpStatus.BAD_REQUEST);
    }

    public static void isKangrooNotExist(Map<Integer, Kangaroo> kangaroos, int id) {
        if (!kangaroos.containsKey(id)) throw new KangrooException(id +
                " Kangroo with given ID is not exist", HttpStatus.NOT_FOUND);
    }

    public static void isKangrooExist(Map<Integer, Kangaroo> kangaroos, int id) {
        if (kangaroos.containsKey(id)) throw new KangrooException(id +
                " Kangroo with given ID is already exist", HttpStatus.BAD_REQUEST);
    }
}
