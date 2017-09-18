package com.jpa.project.sitemesh;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.CoreHtmlTagRuleBundle;
import org.sitemesh.content.tagrules.html.DivExtractingTagRuleBundle;
import org.sitemesh.content.tagrules.html.Sm2TagRuleBundle;

/**
 * Created by IMC021 on 2017. 9. 11..
 */
public class SiteMeshFilter extends ConfigurableSiteMeshFilter{
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder){
        builder.addDecoratorPath("/*","/WEB-INF/jsp/index.jsp")
                .addTagRuleBundle(new Sm2TagRuleBundle());
                //.addExcludedPath("/js")
                //.addExcludedPath("/plugins");
    }
}
