package com.globallogic.qa.training.functional.model

class Quote {

    String type
    Value value

    static getDefaultQuote(String quote) {
        new Quote(value: new Value(quote: quote))
    }
}
