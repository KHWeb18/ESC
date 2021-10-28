package utility.python;

import com.esc.khweb.controller.request.BoardReportRequest;
import com.esc.khweb.controller.request.BoardRequest;
import org.springframework.web.client.RestTemplate;

public class BoardReportKakaoAlarmWithPython {


    public  String KakaotalkAlarm(BoardReportRequest boardReportRequest) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject(
                "http://localhost:5000/spring2pythonRequestWithData",
                boardReportRequest,
                String.class

        );
    }
}
