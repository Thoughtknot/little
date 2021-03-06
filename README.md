# Little

This is a small programming language compiling to LC3 (Little Computer 3) assembly & LC3 machine code.

## Building:

`mvn clean package`

# Running:

To compile Little to an LC3 machine code file:
`java -cp target/little-jar-with-dependencies.jar org.aldous.little.Little --f src/program.ltl --o bin/program.obj --a`
(--a creates a parallel LC3 assembly file of the intermediate state between Little and LC3 machine code.)


To assemble LC3 assembly language:
`java -cp target/little-jar-with-dependencies.jar org.aldous.little.assembler.Lc3a --f test.lc3 --o test.obj`

## Examples:
```
def K;
def L;
K <- -5;
L <- 'C';
loop (K) {
    K <- K + 1;
    print L;
    print '\n';
};
```

```
def hello[3];
hello[0] <- 'H';
hello[1] <- 'i';
hello[2] <- '\n';
print hello;
```