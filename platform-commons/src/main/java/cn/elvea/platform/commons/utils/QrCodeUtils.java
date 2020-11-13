package cn.elvea.platform.commons.utils;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * QrCodeUtils
 *
 * <p>{@link org.springframework.context.support.ApplicationObjectSupport} is a
 * http://haraldk.github.io/TwelveMonkeys/
 * @author elvea
 */
public abstract class QrCodeUtils {

    /**
     * 从图片中识别二维码
     */
    public static String decode(File file) throws IOException, NotFoundException {
        BufferedImage image = ImageIO.read(file);
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        Binarizer binarizer = new HybridBinarizer(source);
        BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
        Map<DecodeHintType, Object> hints = Maps.newEnumMap(DecodeHintType.class);
        hints.put(DecodeHintType.CHARACTER_SET, Charsets.UTF_8.name());
        return new MultiFormatReader().decode(binaryBitmap, hints).getText();
    }

}
