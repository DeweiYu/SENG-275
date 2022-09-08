package lab06;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class InvoiceFilterTest {
    private InvoiceFilter invoiceFilter;
    private IssuedInvoices issuedInvoices;

    @Test
    void allHighValueInvoices() {
        IssuedInvoices issuedInvoicesMocks = mock(IssuedInvoices.class);
        invoiceFilter = new InvoiceFilter(issuedInvoicesMocks);

        when(issuedInvoicesMocks.all()).thenReturn(List.of(new Invoice(100), new Invoice(300)));

        assertThat(invoiceFilter.lowValueInvoices()).containsExactly();

        verify(issuedInvoicesMocks, times(1)).all();
        verifyNoMoreInteractions(issuedInvoicesMocks);
    }

    @Test
    void allLowValueInvoices() {
        IssuedInvoices issuedInvoicesMock = mock(IssuedInvoices.class, withSettings().verboseLogging());
        invoiceFilter = new InvoiceFilter(issuedInvoicesMock);
        when(issuedInvoicesMock.all()).thenReturn(List.of(new Invoice(43), new Invoice(99)));
        assertThat(invoiceFilter.lowValueInvoices()).containsExactly(new Invoice(43), new Invoice(99));
        verify(issuedInvoicesMock).all();
    }

    @Test
    void someLowValueInvoices() {
        IssuedInvoices issuedLowInvoicesMock = mock(IssuedInvoices.class);
        invoiceFilter = new InvoiceFilter(issuedLowInvoicesMock);

        when(issuedLowInvoicesMock.all()).thenReturn(List.of(new Invoice(30), new Invoice(300)));

        assertThat(invoiceFilter.lowValueInvoices()).containsExactly(new Invoice(30));

        verify(issuedLowInvoicesMock, times(1)).all();
        verifyNoMoreInteractions(issuedLowInvoicesMock);
    }

}
