#!/usr/bin/env python2
# -*- coding: utf-8 -*-
##################################################
# GNU Radio Python Flow Graph
# Title: Sdr
# Generated: Mon Feb 27 23:06:46 2017
##################################################

print "Program Start"

if __name__ == '__main__':
    import ctypes
    import sys
    if sys.platform.startswith('linux'):
        try:
            x11 = ctypes.cdll.LoadLibrary('libX11.so')
            x11.XInitThreads()
        except:
            print "Warning: failed to XInitThreads()"

from gnuradio import blocks
from gnuradio import eng_notation
from gnuradio import filter
from gnuradio import gr
from gnuradio import gr, blocks
from gnuradio import uhd
from gnuradio.eng_option import eng_option
from gnuradio.filter import firdes
from grc_gnuradio import wxgui as grc_wxgui
from optparse import OptionParser
import time
import wx



class SDR(grc_wxgui.top_block_gui):

    def __init__(self):
        grc_wxgui.top_block_gui.__init__(self, title="Sdr")

        ##################################################
        # Variables
        ##################################################
        self.samp_rate = samp_rate = 5e6
        self.freq = freq = 130e6
        self.bandwidth = bandwidth = 1e6
        self.Items_skiphead = Items_skiphead = 256
        self.Items_head = Items_head = 8448

        ##################################################
        # Blocks
        ##################################################
        self.uhd_usrp_source_0 = uhd.usrp_source(
        	",".join(("", "")),
        	uhd.stream_args(
        		cpu_format="fc32",
        		channels=range(2),
        	),
        )
        self.uhd_usrp_source_0.set_clock_rate(10e6, uhd.ALL_MBOARDS)
        self.uhd_usrp_source_0.set_samp_rate(samp_rate)
        self.uhd_usrp_source_0.set_center_freq(freq, 0)
        self.uhd_usrp_source_0.set_gain(0, 0)
        self.uhd_usrp_source_0.set_antenna('RX2', 0)
        self.uhd_usrp_source_0.set_bandwidth(bandwidth, 0)
        self.uhd_usrp_source_0.set_center_freq(freq, 1)
        self.uhd_usrp_source_0.set_gain(0, 1)
        self.uhd_usrp_source_0.set_antenna('RX2', 1)
        self.uhd_usrp_source_0.set_bandwidth(bandwidth, 1)
        self.blocks_skiphead_0_1 = blocks.skiphead(gr.sizeof_gr_complex*1, Items_skiphead)
        self.blocks_skiphead_0_0 = blocks.skiphead(gr.sizeof_gr_complex*1, Items_skiphead)
        self.blocks_interleave_1 = blocks.interleave(gr.sizeof_float*1, 1)
        self.blocks_head_0_0 = blocks.head(gr.sizeof_gr_complex*1, Items_head)
        self.blocks_head_0 = blocks.head(gr.sizeof_gr_complex*1, Items_head)
        self.blocks_float_to_complex_0 = blocks.float_to_complex(1)
        self.blocks_file_meta_sink_0 = blocks.file_meta_sink(gr.sizeof_gr_complex*1, 'D:\\Workspace\\SDR', samp_rate, 1, blocks.GR_FILE_FLOAT, True, 1000000, "", False)
        self.blocks_file_meta_sink_0.set_unbuffered(False)
        self.blocks_complex_to_float_0_0 = blocks.complex_to_float(1)
        self.blocks_complex_to_float_0 = blocks.complex_to_float(1)
        self.band_pass_filter_0_0 = filter.fir_filter_ccf(1, firdes.band_pass(
        	1, samp_rate, 128e6, 132e6, 1e6, firdes.WIN_HAMMING, 6.76))
        self.band_pass_filter_0 = filter.fir_filter_ccf(1, firdes.band_pass(
        	1, samp_rate, 128e6, 132e6, 1e6, firdes.WIN_HAMMING, 6.76))

        ##################################################
        # Connections
        ##################################################
        self.connect((self.band_pass_filter_0, 0), (self.blocks_head_0, 0))    
        self.connect((self.band_pass_filter_0_0, 0), (self.blocks_head_0_0, 0))    
        self.connect((self.blocks_complex_to_float_0, 1), (self.blocks_interleave_1, 1))    
        self.connect((self.blocks_complex_to_float_0, 0), (self.blocks_interleave_1, 0))    
        self.connect((self.blocks_complex_to_float_0_0, 1), (self.blocks_interleave_1, 3))    
        self.connect((self.blocks_complex_to_float_0_0, 0), (self.blocks_interleave_1, 2))    
        self.connect((self.blocks_float_to_complex_0, 0), (self.blocks_file_meta_sink_0, 0))    
        self.connect((self.blocks_head_0, 0), (self.blocks_skiphead_0_0, 0))    
        self.connect((self.blocks_head_0_0, 0), (self.blocks_skiphead_0_1, 0))    
        self.connect((self.blocks_interleave_1, 0), (self.blocks_float_to_complex_0, 0))    
        self.connect((self.blocks_skiphead_0_0, 0), (self.blocks_complex_to_float_0_0, 0))    
        self.connect((self.blocks_skiphead_0_1, 0), (self.blocks_complex_to_float_0, 0))    
        self.connect((self.uhd_usrp_source_0, 1), (self.band_pass_filter_0, 0))    
        self.connect((self.uhd_usrp_source_0, 0), (self.band_pass_filter_0_0, 0))    

    def get_samp_rate(self):
        return self.samp_rate

    def set_samp_rate(self, samp_rate):
        self.samp_rate = samp_rate
        self.uhd_usrp_source_0.set_samp_rate(self.samp_rate)
        self.band_pass_filter_0_0.set_taps(firdes.band_pass(1, self.samp_rate, 128e6, 132e6, 1e6, firdes.WIN_HAMMING, 6.76))
        self.band_pass_filter_0.set_taps(firdes.band_pass(1, self.samp_rate, 128e6, 132e6, 1e6, firdes.WIN_HAMMING, 6.76))

    def get_freq(self):
        return self.freq

    def set_freq(self, freq):
        self.freq = freq
        self.uhd_usrp_source_0.set_center_freq(self.freq, 0)
        self.uhd_usrp_source_0.set_center_freq(self.freq, 1)

    def get_bandwidth(self):
        return self.bandwidth

    def set_bandwidth(self, bandwidth):
        self.bandwidth = bandwidth
        self.uhd_usrp_source_0.set_bandwidth(self.bandwidth, 0)
        self.uhd_usrp_source_0.set_bandwidth(self.bandwidth, 1)

    def get_Items_skiphead(self):
        return self.Items_skiphead

    def set_Items_skiphead(self, Items_skiphead):
        self.Items_skiphead = Items_skiphead

    def get_Items_head(self):
        return self.Items_head

    def set_Items_head(self, Items_head):
        self.Items_head = Items_head
        self.blocks_head_0_0.set_length(self.Items_head)
        self.blocks_head_0.set_length(self.Items_head)


def main(top_block_cls=SDR, options=None):

    tb = top_block_cls()
    tb.Start(True)
    tb.Wait()


if __name__ == '__main__':
    main()
