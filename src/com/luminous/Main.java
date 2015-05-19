package com.luminous;

import com.google.gson.Gson;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
import com.luminous.exception.NotEnoughArgumentsException;
import com.luminous.domain.Rule;
import com.luminous.domain.Validator;
import com.luminous.exception.RuleNotSupportedException;
import com.luminous.utils.Util;

import java.io.*;
import java.nio.file.NotDirectoryException;
import java.util.Set;

public class Main {

    /** The original PDF file. */
    public static final String INPUT
            = "res/challenge-source.pdf";
    public static final String INPUT_2
            = "res/datasheet.pdf";
    /** The resulting text file with the field info. */
    public static final String RESULT
            = "res/form_info.txt";
    private static final String ACTION_FILL = "fill";


    public static void main(String[] args) throws IOException, DocumentException {

        PrintStream writer = System.out;
        Validator validator = new Validator();
        try {
            validator.validate(args);
        } catch (NotEnoughArgumentsException e) {
            writer.println(e.getMessage());
            return;
        } catch (FileNotFoundException e) {
            writer.println(e.getMessage());
            return;
        } catch (NotDirectoryException e) {
            writer.println(e.getMessage());
            return;
        }

//        printPdfForms(INPUT_2);
        manipulatePdf(INPUT_2, "res/Result.pdf");


        Gson gson = new Gson();
/*
        Rule rule = new Rule("fill", "textFirstName", "Calin");
        String r = gson.toJson(rule);
*/

        String in = Util.readFile("res/fill_rule.json");

        Rule rule = gson.fromJson(in, Rule.class);

//        RuleInterpreter interpreter = new RuleInterpreter(rule);

        if (rule.getAction().equals(ACTION_FILL)) {
            String fieldName = rule.getFieldName();
            String value = rule.getValue();
        }


    }

    public static void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        AcroFields form = stamper.getAcroFields();
        form.setField("title", "Calin");
//        form.setFieldProperty("text_2", "fflags", 0, null);
//        form.regenerateField("text_4");
        stamper.close();
        reader.close();
    }

    private static void printPdfForms(String src) {
        PrintStream writer = null;
        try {
            writer = System.out;
            PdfReader reader = new PdfReader(src);

            AcroFields form = reader.getAcroFields();
            Set<String> fields = form.getFields().keySet();

            for (String key : fields) {
                writer.print(key + ": ");
                switch (form.getFieldType(key)) {
                    case AcroFields.FIELD_TYPE_CHECKBOX:
                        writer.println("Checkbox");
                        break;
                    case AcroFields.FIELD_TYPE_COMBO:
                        writer.println("Combobox");
                        break;
                    case AcroFields.FIELD_TYPE_LIST:
                        writer.println("List");
                        break;
                    case AcroFields.FIELD_TYPE_NONE:
                        writer.println("None");
                        break;
                    case AcroFields.FIELD_TYPE_PUSHBUTTON:
                        writer.println("Pushbutton");
                        break;
                    case AcroFields.FIELD_TYPE_RADIOBUTTON:
                        writer.println("Radiobutton");
                        break;
                    case AcroFields.FIELD_TYPE_SIGNATURE:
                        writer.println("Signature");
                        break;
                    case AcroFields.FIELD_TYPE_TEXT:
                        writer.println("Text");
                        break;
                    default:
                        writer.println("?");
                }
            }
/*
            String[] states = form.getAppearanceStates("CP_1");
            for (int i = 0; i < states.length; i++) {
                writer.print(" - ");
                writer.println(states[i]);
            }

            states = form.getAppearanceStates("category");
            for (int i = 0; i < states.length - 1; i++) {
                writer.print(states[i]);
                writer.print(", ");
            }*/

            reader.close();

        } catch (IOException e) {
            writer.println(e.getMessage());
            return;
        }
    }

}
