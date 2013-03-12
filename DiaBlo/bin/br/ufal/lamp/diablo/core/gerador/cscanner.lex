package calculadora;

import java_cup.runtime.Symbol;

%%
%cup
%%

"+"                 {return new Symbol(JMSymbols.PLUS); }

[0-9]+              {return new Symbol(JMSymbols.INT, new Integer(yytext())); }

[ \t\r\n\f]         {/* ignore white space */}
.                   {System.err.println("Illegal character: "+yytext());}