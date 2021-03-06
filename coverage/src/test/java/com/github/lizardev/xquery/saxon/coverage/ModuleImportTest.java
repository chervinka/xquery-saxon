package com.github.lizardev.xquery.saxon.coverage;

import org.junit.Test;
import com.github.lizardev.xquery.saxon.coverage.report.Report;

import static com.github.lizardev.xquery.saxon.coverage.TestConstants.IMPORT_LIBRARY_MODULE;
import static com.github.lizardev.xquery.saxon.coverage.TestConstants.IMPORT_MAIN_MODULE;
import static com.github.lizardev.xquery.saxon.coverage.assertj.ProjectAssertions.assertThat;

public class ModuleImportTest extends AbstractCoverageTest {

    @Test
    public void shouldCollectCoverageOfImportedModule() {
        boolean result = xqueryExecutor.execute(IMPORT_MAIN_MODULE);

        assertThat(result).isTrue();
        Report report = coverageService.getReport();
        assertThat(report).hasNumberOfModules(2);
        assertThat(report.getModuleReport(IMPORT_LIBRARY_MODULE)).isFullyCovered();
        assertThat(report.getModuleReport(IMPORT_MAIN_MODULE)).isFullyCovered();
    }
}
