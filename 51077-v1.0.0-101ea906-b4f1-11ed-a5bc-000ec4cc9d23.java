/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__connect_tcp_subtract_19.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-19.tmpl.java
*/
/*
* @description
* CWE: 191 Integer Underflow
* BadSource: connect_tcp Read data using an outbound tcp connection
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: subtract
*    GoodSink: Ensure there will not be an underflow before performing the subtraction
*    BadSink : Unchecked subtraction can lead to underflow
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE191_Integer_Underflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Logger;

import java.security.SecureRandom;

public class CWE191_Integer_Underflow__connect_tcp_subtract_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init data */
        data = -1;

        Socket sock = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            // Read data using an outbound tcp connection
            sock = new Socket("host.example.org", 39544);

            /* read input from socket */
            instrread = new InputStreamReader(sock.getInputStream());
            buffread = new BufferedReader(instrread);

            String s_data = buffread.readLine();
            data = Integer.parseInt(s_data.trim());
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( buffread != null )
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
            finally {
                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing instrread");
                }
            }

            /* clean up socket objects */
            try {
                if( sock != null )
                {
                    sock.close();
                }
            }
            catch( IOException e )
            {
                log_bad.warning("Error closing sock");
            }
        }

        {

            int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */

            /* POTENTIAL FLAW: if (data-valueToSub) < MIN_VALUE this will underflow */
            int result = (data - valueToSub);

            IO.writeLine("result: " + result);

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */
            int result = 0;

            /* FIX: Add a check to prevent an underflow from occurring */
            if (data >= (Integer.MIN_VALUE+valueToSub))
            {
                result = (data - valueToSub);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("Input value is too small to perform subtraction.");
            }

        }
    }

    /* goodG2B() - use goodsource and badsink by moving BadSource and BadSink to after return */
    private void goodG2B() throws Throwable
    {
        int data;
        {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

            int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */

            /* POTENTIAL FLAW: if (data-valueToSub) < MIN_VALUE this will underflow */
            int result = (data - valueToSub);

            IO.writeLine("result: " + result);

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            Logger log_bad = Logger.getLogger("local-logger");

            /* init data */
            data = -1;

            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try {
                // Read data using an outbound tcp connection
                sock = new Socket("host.example.org", 39544);

                /* read input from socket */
                instrread = new InputStreamReader(sock.getInputStream());
                buffread = new BufferedReader(instrread);

                String s_data = buffread.readLine();
                data = Integer.parseInt(s_data.trim());
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            catch( NumberFormatException nfe )
            {
                log_bad.warning("Error with number parsing");
            }
            finally {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing sock");
                }
            }

            int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */

            /* POTENTIAL FLAW: if (data-valueToSub) < MIN_VALUE this will underflow */
            int result = (data - valueToSub);

            IO.writeLine("result: " + result);

        }
    }

    /* goodB2G() - use badsource and goodsink by switching statements around return */
    private void goodB2G() throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init data */
        data = -1;

        Socket sock = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            // Read data using an outbound tcp connection
            sock = new Socket("host.example.org", 39544);

            /* read input from socket */
            instrread = new InputStreamReader(sock.getInputStream());
            buffread = new BufferedReader(instrread);

            String s_data = buffread.readLine();
            data = Integer.parseInt(s_data.trim());
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( buffread != null )
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
            finally {
                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing instrread");
                }
            }

            /* clean up socket objects */
            try {
                if( sock != null )
                {
                    sock.close();
                }
            }
            catch( IOException e )
            {
                log_bad.warning("Error closing sock");
            }
        }

        {

            int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */
            int result = 0;

            /* FIX: Add a check to prevent an underflow from occurring */
            if (data >= (Integer.MIN_VALUE+valueToSub))
            {
                result = (data - valueToSub);
                IO.writeLine("result: " + result);
            }
            else {
                IO.writeLine("Input value is too small to perform subtraction.");
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            int valueToSub = (new SecureRandom()).nextInt(99)+1; /* subtracting at least 1 */

            /* POTENTIAL FLAW: if (data-valueToSub) < MIN_VALUE this will underflow */
            int result = (data - valueToSub);

            IO.writeLine("result: " + result);

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
