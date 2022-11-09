package io.datajek.springdata.tennisplayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerDao dao;

    public static void main(String[] args) {
        SpringApplication.run(TennisPlayerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("Inserting Player 2: {}", dao.insertPlayer(
                                                new Player(2, "Kalata", "Bulgarian",
                                                        new Date(System.currentTimeMillis()),
                                                        18)));

        logger.info("Updating Player with Id 2: {}", dao.updatePlayer(
                                                new Player(2, "Ilko", "England",
                                                        Date.valueOf("2000-10-01"), 18)));

        logger.info("Deleting Player with Id 2: {}", dao.deletePlayerById(2));

        logger.info("All Players Data: {}", dao.getAllPlayers());
    }
}
