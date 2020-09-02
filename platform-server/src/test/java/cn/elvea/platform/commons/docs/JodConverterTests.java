package cn.elvea.platform.commons.docs;

import lombok.extern.slf4j.Slf4j;
import org.jodconverter.core.DocumentConverter;
import org.jodconverter.core.office.OfficeManager;
import org.jodconverter.core.office.OfficeUtils;
import org.jodconverter.remote.RemoteConverter;
import org.jodconverter.remote.office.RemoteOfficeManager;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;

/**
 * JodConverterTests
 *
 * @author elvea
 */
@Slf4j
public class JodConverterTests {

    @Test
    public void test() {
        ClassPathResource docResource = new ClassPathResource("docs/test.doc");
        ClassPathResource pptResource = new ClassPathResource("docs/test.ppt");
        ClassPathResource xlsResource = new ClassPathResource("docs/test.xls");

        File targetFile = new File("docs");
        File docTargetFile = new File(targetFile, "test.doc.pdf");
        File pptTargetFile = new File(targetFile, "test.ppt.pdf");
        File xlsTargetFile = new File(targetFile, "test.xls.pdf");

        OfficeManager manager = null;
        try {
            manager = RemoteOfficeManager.builder()
                    .urlConnection("http://192.168.0.100:9980")
                    .connectTimeout(60000L)
                    .build();
            manager.start();

            DocumentConverter converter = RemoteConverter.make(manager);

            log.debug(targetFile.getAbsolutePath());
            if (targetFile.mkdirs()) {
                log.debug("create new folder {}", targetFile.getAbsolutePath());
            }

            log.debug(docResource.getFile().getAbsolutePath());
            docTargetFile.deleteOnExit();
            if (docTargetFile.createNewFile()) {
                log.debug("create new file {}", docTargetFile.getAbsolutePath());
            }
            converter.convert(docResource.getFile()).to(docTargetFile).execute();
            log.debug(docTargetFile.getAbsolutePath());

            log.debug(pptResource.getFile().getAbsolutePath());
            pptTargetFile.deleteOnExit();
            if (pptTargetFile.createNewFile()) {
                log.debug("create new file {}", pptTargetFile.getAbsolutePath());
            }
            converter.convert(pptResource.getFile()).to(pptTargetFile).execute();
            log.debug(pptTargetFile.getAbsolutePath());

            log.debug(xlsResource.getFile().getAbsolutePath());
            xlsTargetFile.deleteOnExit();
            if (xlsTargetFile.createNewFile()) {
                log.debug("create new file {}", xlsTargetFile.getAbsolutePath());
            }
            converter.convert(xlsResource.getFile()).to(xlsTargetFile).execute();
            log.debug(xlsTargetFile.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            OfficeUtils.stopQuietly(manager);
            // 删除现有文件
            targetFile.deleteOnExit();
        }
        log.debug("finish.");
    }

}
