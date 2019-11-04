import com.aliyuncs.exceptions.ClientException;
import com.leyou.LeyouSmsApplication;
import com.leyou.sms.config.SmsProperties;
import com.leyou.sms.utils.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@EnableConfigurationProperties(SmsProperties.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LeyouSmsApplication.class)
public class Test1 {
    @Autowired
    private SmsProperties smsProperties;
    @Autowired
    private SmsUtils smsUtils;

    @Test
    public void Test2(){
        //System.out.println(smsProperties.getAccessKeyId());
        //System.out.println(smsProperties.getAccessKeySecret());
        System.out.println(smsProperties.getSignName());
        System.out.println(smsProperties.getVerifyCodeTemplate());
    }
    @Test
    public void Test3() throws ClientException {
        this.smsUtils.sendSms("18070390618","123",this.smsProperties.getSignName(),this.smsProperties.getVerifyCodeTemplate());
    }
}
