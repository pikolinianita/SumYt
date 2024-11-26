package pl.lcc.SumYt.ai.carrier;

import java.util.List;

public class ChatCall {

    String model;
    List<Message> messages;
    Float temperature;
    Float frequency_penalty; //number or null
    Integer max_tokens;
    String user;

//   response_formatobject or nullOptional
//
//    An object specifying the format that the model must output.
//
//    Setting to { "type": "json_object" } enables JSON mode, which guarantees the message the model generates is valid JSON.
//
//    Important: when using JSON mode, you must also instruct the model to produce JSON yourself via a system or user message.
//    typestringOptionalDefaults to text
//
//    Must be one of text or json_object.

    Object response_format;
}
