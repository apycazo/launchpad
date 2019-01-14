package es.jander.launchpad.spring4jersey.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Outcome {

  @Builder.Default
  private long timestamp = Instant.now().toEpochMilli();
  @Builder.Default
  private boolean successful = false;
  private String message;
  private Object content;
}
