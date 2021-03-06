import com.github.lizardev.xquery.saxon.coverage.util.XQueryExecutor;
import com.github.lizardev.xquery.saxon.support.trace.SpiTraceExtensionProvider;
import org.junit.Test;

import static com.github.lizardev.xquery.saxon.coverage.TestConstants.TWO_BRANCHES_MODULE;
import static com.github.lizardev.xquery.saxon.coverage.assertj.ProjectAssertions.assertThat;
import static com.github.lizardev.xquery.saxon.coverage.util.ExecutionContext.executionContext;
import static com.github.lizardev.xquery.saxon.coverage.util.XQueryExecutorBuilder.xQueryExecutor;

public class BranchTwoTest {

    @Test
    public void invokesBranchTwo() {
        XQueryExecutor xqueryExecutor = xQueryExecutor()
                .withTraceExtension(SpiTraceExtensionProvider.INSTANCE.getTraceExtension())
                .build();

        boolean result = xqueryExecutor.execute(TWO_BRANCHES_MODULE, executionContext()
                .withExternalVariable("switch", false).build());

        assertThat(result).isFalse();
    }
}
