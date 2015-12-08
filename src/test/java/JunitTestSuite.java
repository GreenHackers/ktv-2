
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Johan Verhoeven <jrh.verhoeven@student.fontys.nl>
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ApiAuthenticationTest.class,
    CompetitionControlTest.class,
    CreateUserWithEmptyDataTest.class,
    NewRoundTest.class,
    RoundControlTest.class,
    ShowCurrentCompetitionInfoTest.class,
    TeamControlTest.class
})
public class JunitTestSuite {
}
