/*
 * Copyright (c) 2012-2014 nadavc <https://twitter.com/nadavc>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the WTFPL, Version 2, as published by Sam Hocevar.
 * See the COPYING file for more details.
 */

package org.groovykoans.koan09

import org.codehaus.groovy.runtime.InvokerHelper

class Robot {
    // ------------ START EDITING HERE ----------------------
    int x = 0
    int y = 0

    void left() { x = x - 1 }
    void right() { x = x + 1 }
    void up() { y = y + 1 }
    void down() { y = y - 1 }

    String processRequest(String request) {
        switch (request) {
            case ~/Up.*/:
                this.up()
                processRequest(request.substring(2))
                break
            case ~/Down.*/:
                this.down()
                processRequest(request.substring(4))
                break
            case ~/Left.*/:
                this.left()
                processRequest(request.substring(4))
                break
            case ~/Right.*/:
                this.right()
                processRequest(request.substring(5))
                break
            default:
                ""
        }
    }

    def invokeMethod(String name, Object args) {
        if(name.startsWith('go')) {
            processRequest(name.substring(2))
        }
    }
    // ------------ STOP EDITING HERE  ----------------------
}
