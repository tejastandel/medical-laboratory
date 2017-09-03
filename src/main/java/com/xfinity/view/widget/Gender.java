/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xfinity.view.widget;

/**
 *
 * @author supun
 */
public enum Gender {

    MALE(0), FEMALE(1), UNKNOWN(-1);

    public final int VALUE;

    private Gender(int value) {
        this.VALUE = value;
    }
}
