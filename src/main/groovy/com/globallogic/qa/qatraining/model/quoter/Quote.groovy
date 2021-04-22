package com.globallogic.qa.qatraining.model.quoter

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Quote {

    String type
    Value value
}
