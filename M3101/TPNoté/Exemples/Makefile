INC=-I . -I ../libIPC
LIB=-L ../libIPC -lIPC -lpthread
LD=gcc -o
CC=gcc -c

TARGET=initRessources deleteRessources readShm writeShm readTube writeTube
OBJ=$(patsubst %, %.o, $(TARGET))

all: $(TARGET)

$(TARGET): % : %.o
	$(LD) $@ $^ $(LIB)

$(OBJ): %.o : %.c
	$(CC) $< $(INC)

clean:
	rm $(TARGET) $(OBJ)

