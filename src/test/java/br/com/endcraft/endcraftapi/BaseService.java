package br.com.endcraft.endcraftapi;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.mysql.cj.jdbc.MysqlDataSourceFactory;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@ActiveProfiles("test")
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DirtiesContextBeforeModesTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
public class BaseService {

    @Bean
    public DatabaseConfigBean databaseConfigBean() {
        DatabaseConfigBean databaseConfigBean = new DatabaseConfigBean();
        databaseConfigBean.setDatatypeFactory(new MySqlDataTypeFactory());
        return databaseConfigBean;
    }
}
