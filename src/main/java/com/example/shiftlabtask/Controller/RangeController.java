package com.example.shiftlabtask.Controller;

import com.example.shiftlabtask.CustomInterval;
import com.example.shiftlabtask.IntervalProcessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/intervals")
public class RangeController {

    private final ObjectMapper objectMapper;

    public RangeController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }



    @PostMapping("/merge")
    public void Merge(@RequestBody List<CustomInterval> intervals, @RequestParam("kind") String kind){
        intervals.forEach(interval -> interval.setIntervalKind(kind));
        IntervalProcessor.processIntevals(intervals);
    }

    @GetMapping("/min")
    public ResponseEntity<String> getMinimalInterval( @RequestParam("kind") String kind) throws JsonProcessingException {
        CustomInterval minimal = IntervalProcessor.getmin(kind);
        String json = objectMapper.writeValueAsString(minimal);
        return ResponseEntity.ok(json);
    }


}
