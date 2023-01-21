import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.LoginRegistrationScreen;
import screens.SplashScreen;

public class LaunchTest extends AppiumConfig {

    @Test
    public void launch(){
        String version=new SplashScreen(driver).getCurrentVersion();
        Assert.assertTrue((version.contains("1.0.0")));
    }
   /* @Test
    public void launchLoginRegistrationForm(){
        String typeEmail=new LoginRegistrationScreen(driver).getCurrentEmail();
        Assert.assertTrue(typeEmail.contains("Type Email"));
    }*/



}
