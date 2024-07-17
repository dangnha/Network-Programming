#include "NetworkServices.h"
#include <WinSock2.h>


class NetworkServices
{
public:

	static int sendMessage(SOCKET curSocket, char* message, int messageSize);
	static int receiveMessage(SOCKET curSocket, char* buffer, int bufSize);
};

int NetworkServices::sendMessage(SOCKET curSocket, char* message, int messageSize)
{
    return send(curSocket, message, messageSize, 0);
}
int NetworkServices::receiveMessage(SOCKET curSocket, char* buffer, int bufSize)
{
	return recv(curSocket, buffer, bufSize, 0);
}