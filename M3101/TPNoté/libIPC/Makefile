all: libIPC.a

# Bibliotheque
# ============
libIPC.a: ipc.c ipc.h
	gcc -c ipc.c
	ar -r libIPC.a ipc.o
	ranlib libIPC.a
	rm ipc.o

clean:
	rm libIPC.a

