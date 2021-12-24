package com.example.circumference.view;

import com.example.circumference.services.PiCalculationService;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.material.Material;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Theme( Material.class )
@Route
@PageTitle( "Circumference of Sun" )
public class MainView extends VerticalLayout {

    public MainView ( @Autowired PiCalculationService piCalculationService ) {
        // currentKnownPi
        BigDecimal currentKnownPi = piCalculationService.getMostAccuratePiValue().getCurrentKnownPi();
        BigDecimal radiusOfSun = new BigDecimal( 696340 );

        // layout styling
        setHeightFull();
        setAlignItems( Alignment.CENTER );
        setJustifyContentMode( JustifyContentMode.CENTER );

        add( createSpan( "Radius of sun in Kilometers" ), new Span( radiusOfSun.toPlainString() ) );
        add( createSpan( "CurrentKnownPi" ), createTextArea( currentKnownPi.toPlainString() ) );

        BigDecimal circumference = BigDecimal.valueOf( 2 ).multiply( currentKnownPi ).multiply( radiusOfSun );
        add( createSpan( "Circumference ( 2* pi * radius )" ), createTextArea( circumference.toPlainString() ) );

    }

    private TextArea createTextArea ( String value ) {
        TextArea textArea = new TextArea();
        textArea.setEnabled( false );
        textArea.setWidthFull();
        textArea.setValue( value );

        return textArea;
    }

    private Span createSpan ( String text ) {
        Span span = new Span( text );
        span.getStyle().set( "font-weight", "bold" );

        return span;
    }
}
