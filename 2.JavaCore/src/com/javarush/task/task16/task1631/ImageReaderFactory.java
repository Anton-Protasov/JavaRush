package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes pic) {
        ImageReader imageReader = null;
        if (pic == ImageTypes.BMP) {
            imageReader = new BmpReader();
        } else if (pic == ImageTypes.PNG) {
            imageReader = new PngReader();
        } else if (pic ==ImageTypes.JPG) {
            imageReader = new JpgReader();
        } else {
            throw new IllegalArgumentException ("Неизвестный тип картинки");
        }
        return imageReader;
    }
}
