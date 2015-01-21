package pl.edu.wat.swp;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * 
 * @author Krzysztof Jedynak @email jedynakpoczta@gmail.com
 * @date 21 sty 2015 Filter for sitemash decorator.
 */
public class MySiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/WEB-INF/jsp/decorator.jsp");
    }
}