#ifndef Header_SuperpoweredExample
#define Header_SuperpoweredExample

#include <SLES/OpenSLES.h>
#include <SLES/OpenSLES_Android.h>
#include <math.h>
#include <pthread.h>

#include "SuperpoweredExample.h"
#include "SuperpoweredAdvancedAudioPlayer.h"
#include "SuperpoweredFilter.h"
#include "SuperpoweredRoll.h"
#include "SuperpoweredFlanger.h"
#include "SuperpoweredMixer.h"

#include "SuperpoweredWhoosh.h"
#include "SuperpoweredGate.h"
#include "SuperpoweredEcho.h"
#include "SuperpoweredReverb.h"
#include "SuperpoweredTimeStretching.h"


#define NUM_BUFFERS 2
#define HEADROOM_DECIBEL 3.0f
static const float headroom = powf(10.0f, -HEADROOM_DECIBEL * 0.025);

class SuperpoweredExample {
public:

	SuperpoweredExample(const char *path, int *params);
	~SuperpoweredExample();

	void process(SLAndroidSimpleBufferQueueItf caller);
	void onPlayPause(bool play);
	void onCrossfader(int value);
	void onFxSelect(int value);
	void onFxOff();
	void onFxValue(int value);

private:
	SLObjectItf openSLEngine, outputMix, bufferPlayer;
	SLAndroidSimpleBufferQueueItf bufferQueue;

    SuperpoweredAdvancedAudioPlayer *playerA, *playerB;
    SuperpoweredRoll *roll;
    SuperpoweredFilter *filter;
    SuperpoweredFlanger *flanger;
    SuperpoweredStereoMixer *mixer;

    SuperpoweredWhoosh *whoosh;
    SuperpoweredGate *gate;
    SuperpoweredEcho *echo;
    SuperpoweredReverb *reverb;
    SuperpoweredTimeStretching *stretch;

    unsigned char activeFx;
    float crossValue, volA, volB;
    pthread_mutex_t mutex;

	float *outputBuffer[NUM_BUFFERS];
	int currentBuffer, buffersize;
};

#endif