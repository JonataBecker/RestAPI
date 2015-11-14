package br.com.becker.restapi;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Classe responsável pelo teste de busca de implementações
 * 
 * @author Jonata Becker
 */
public class FindImplementationTest {
    
    @Test
    public void findClass() throws FindImplementarionException {
        Assert.assertNotNull(FindImplementation.find(List.class));
    }
    
    @Test(expected = FindImplementarionException.class)
    public void get() throws FindImplementarionException {
        Assert.assertNotNull(FindImplementation.get(RestAPIConnectionFactory.class));
    }
    
}
