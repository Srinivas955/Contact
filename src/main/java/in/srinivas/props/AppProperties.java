
  package in.srinivas.props;
  
  import java.util.HashMap; import java.util.Map;
  
  import org.springframework.boot.context.properties.ConfigurationProperties;
  import
  org.springframework.boot.context.properties.EnableConfigurationProperties;
  import org.springframework.context.annotation.Configuration;
  
  import lombok.Data;
  
  @ConfigurationProperties(prefix="app")
  @EnableConfigurationProperties  
  @Configuration  
  @Data public class AppProperties {
  
    private Map<String, String> messages = new HashMap<>();
  
  }
 