package example.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import example.capatcha.*;

@RestController
public class DefaultRestController {

  @GetMapping(value = "/image/{capatcha}")
  public ResponseEntity getCapatcha(@PathVariable String capatcha){
    try {
      byte[] imageInByte=CapatchaImage.generate(capatcha);

  		final HttpHeaders headers = new HttpHeaders();
  		headers.setContentType(new MediaType("image","jpeg"));
  		return new ResponseEntity(imageInByte, headers, HttpStatus.CREATED);
  	} catch (Exception e) {
  		e.printStackTrace();
  	}
  	return null;
  }

  @GetMapping("/capatcha")
  @ResponseBody
  public String getCapatcha() {
      return CapatchaText.generate();
  }

  @PostMapping("/")
  @ResponseBody
  public String postCapatcha(@RequestParam String guess, @RequestParam String provided) {
      boolean res = guess.equals(provided);
      System.out.println("Guess: " + guess);
      System.out.println("Provided: " + provided);
      return String.format("Match: %s", res ? "true" : "false");
  }
}
