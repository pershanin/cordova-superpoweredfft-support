var superpoweredFFT =  {
    getComplex: function(real, imag, logSize, forward, successCallback, errorCallback) {
        cordova.exec(
            successCallback, 			// success callback function
            errorCallback, 				// error callback function
            'superpoweredFFT', 			// mapped to our native Java class
            'getComplex', 				// with this action name
            [{                  		
                "real": real,			// real Real part.
                "imag": imag,			// imag Imaginary part.
                "logSize": logSize,		// logSize Should be 4 - 12 (FFT sizes 16 - 4096).
                "forward": forward		// forward Forward or inverse.
            }]
        );
    }
}
module.exports = superpoweredFFT;