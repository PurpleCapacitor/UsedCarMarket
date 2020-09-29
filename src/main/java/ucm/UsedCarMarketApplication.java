package ucm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ucm.services.FileStorageService;

import javax.annotation.Resource;

@SpringBootApplication
public class UsedCarMarketApplication implements CommandLineRunner {

    @Resource
    FileStorageService storageService;


    public static void main(String[] args) {
        SpringApplication.run(UsedCarMarketApplication.class, args);
    }

    @Override
    public void run(String... arg) throws Exception {
        storageService.deleteAll();
        storageService.init();
    }



}
