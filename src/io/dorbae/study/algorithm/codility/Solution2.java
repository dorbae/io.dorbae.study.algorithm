package io.dorbae.study.algorithm.codility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*****************************************************************
 * 
 * Solution2.java
 *
 *****************************************************************
 *
 * @version	0.0.0	2018-05-16 15:02:54	dorbae	최초생성
 * @since 1.0
 * @author dorbae(dorbae.io@gmail.com)
 *
 */
public class Solution2 {
	private static final String[] ALLOWED_EXTESION = new String[] { ".jpg", ".png", ".jpeg"};
	private static final SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss");
	private static long minimumTimestamp = 0L;
	private static long maximumTimestamp = 0L;
	
	enum FieldInfo {
		FILE( 0), CITY( 1), TIMESTAMP( 2);
		
		private final int index;
		
		private FieldInfo( int index) {
			this.index = index;
		}
		
		public int getIndex() {
			return this.index;
		}
	}
	
	/**
	 * 
	 *
	 * @version	1.0.0	2018-05-16 15:13:26	dorbae	최초생성
	 * @since 1.0.0
	 * @author dorbae(dorbae.io@gmail.com)
	 *
	 * @param S
	 * @return
	 */
	public String solution( String S) {
		if ( S == null)
			return "";
		
		String orgData = S.trim();
		if ( orgData.isEmpty())
			return "";
		
		// Windows / Unix, Linux
		String osName = System.getProperty( "os.name");
		String lineDelimiter = "\n";
		if ( osName != null && osName.toLowerCase().startsWith( "win"))
			lineDelimiter = "\r\n";
		
		StringTokenizer recordTokenizer = new StringTokenizer( S, lineDelimiter);
		int M = recordTokenizer.countTokens();
		// Check record count
		if ( M < 1 || M > 100)
			return "";

		
		try {
			minimumTimestamp = TIMESTAMP_FORMAT.parse( "2000-01-01 00:00:00").getTime();
			maximumTimestamp = TIMESTAMP_FORMAT.parse( "2020-12-31 23:59:59").getTime();
		
		} catch ( ParseException e) {
			e.printStackTrace();
			return "";
			
		}
		
		Map< String, Set< FileDefinition>> sortedMap = new HashMap< String, Set< FileDefinition>>();
		Set< FileDefinition> sortedSet = null;
		String record = null;
		String[] fields = null;
		int sequece = 1;
		String fileName = null;
		String fileExtension = null;
		String cityName = null;
		int extensionIndex = -1;
		List< FileDefinition> recordList = new LinkedList< FileDefinition>();
		FileDefinition fileDefinition = null;
		// Separate records and make FileDefinition objects
		while ( recordTokenizer.hasMoreTokens()) {
			record = recordTokenizer.nextToken();
			fields = record.split( ", ");
			if ( fields.length != 3) {
				System.err.println( "Invalid field format");
				return "";
			}
			
			extensionIndex = fields[ FieldInfo.FILE.getIndex()].lastIndexOf( ".");
			if ( extensionIndex < 0) {
				System.err.println( "Invalid format file full name.");
				return "";
			}

			fileName = fields[ 0].substring( 0, extensionIndex);
			fileExtension = fields[ FieldInfo.FILE.getIndex()].substring( extensionIndex, ( fields[ FieldInfo.FILE.getIndex()].length()));
			cityName = fields[ FieldInfo.CITY.getIndex()];
			
			try {
				fileDefinition = new FileDefinition( sequece++, fileName, fileExtension, cityName, fields[ FieldInfo.TIMESTAMP.getIndex()]);
				recordList.add(( fileDefinition));
				
			} catch ( IllegalArgumentException e) {
				System.err.println( e.getMessage());
				return "";
			
			}
			
			// Make Sorted Set / Adding
			sortedSet = sortedMap.get( cityName);
			if ( sortedSet == null) {
				sortedSet = new TreeSet<>( new Comparator< FileDefinition>() {
					@Override
			        public int compare( FileDefinition f1, FileDefinition f2) {
						if ( f1.getTimestamp() > f2.getTimestamp())
							return 1;
						else if ( f1.getTimestamp() < f2.getTimestamp())
							return -1;
						else
							return 0;
					}
			          
				});
				sortedMap.put( cityName, sortedSet);
			}
			
			sortedSet.add( fileDefinition);
			
		}
		
		Iterator< Set< FileDefinition>> mapIterator = sortedMap.values().iterator();
		Iterator< FileDefinition> setIterator = null;
		String sequeceFormat = "%d";
		int citySequece = 1;
		while ( mapIterator.hasNext()) {
			sortedSet = mapIterator.next();
			setIterator = sortedSet.iterator();
			
			if ( sortedSet.size() >= 10)
				sequeceFormat = "%02d";
			else
				sequeceFormat = "%d";
			
			citySequece = 1;
			// City Sequencing 
			while ( setIterator.hasNext()) {
				fileDefinition = setIterator.next();
				fileDefinition.setCitySequence( String.format( sequeceFormat, citySequece++));
				
			}
				
		}
		
		// Make result text
		StringBuilder resultBuilder = new StringBuilder();
		while ( !recordList.isEmpty()) {
			resultBuilder.append( recordList.remove( 0).getFormattingFileName()).append( lineDelimiter);
		}
		
		return resultBuilder.toString();
		
	}
	
	/**
	 * 
	 * @author dorbae
	 *
	 */
	class FileDefinition {
		
		private int sequence;
		private String fileName;
		private String extension;
		private String cityName;
		private long timestamp;
		private String citySequence;
		
		
		/**
		 *
		 * @version	1.0.0	2018-05-16 15:29:26	dorbae	최초생성
		 * @since 1.0.0
		 * @author dorbae(dorbae.io@gmail.com)
		 *
		 * @param sequence
		 * @param fileName
		 * @param extension
		 * @param cityName
		 * @param timestamp
		 */
		public FileDefinition( int sequence, String fileName, String extension, String cityName, String timestamp) throws IllegalArgumentException {
			super();
			this.sequence = sequence;
			
			if ( fileName == null)
				throw new IllegalArgumentException( "File name must be not null");
			
			this.fileName = fileName.trim();
			int nameLength = this.fileName.length();
			if ( nameLength < 1 || nameLength > 20)
				throw new IllegalArgumentException( String.format( "Invalid file name length [%d].", nameLength));
			
			this.extension = extension;
			if ( !this.isAllowedExtension( this.extension))
				throw new IllegalArgumentException( String.format( "Invalid file extension [%s]. Only allow %s.", this.extension, Arrays.toString( ALLOWED_EXTESION)));
			
			if ( cityName == null)
				throw new IllegalArgumentException( "City name must be not null");
			
			this.cityName = cityName.trim();
			nameLength = this.cityName.length();
			if ( nameLength < 1 || nameLength > 20)
				throw new IllegalArgumentException( String.format( "Invalid city name length [%d].", nameLength));
			
			if ( !this.isValidCity( this.cityName)) 
				throw new IllegalArgumentException( String.format( "Invalid city name format [%s].", this.cityName));
				
			this.timestamp = this.parseTimestamp( timestamp);
			
		}
		
		/**
		 * @return the sequence
		 */
		public int getSequence() {
			return sequence;
		}
		/**
		 * @param sequence the sequence to set
		 */
		public void setSequence(int sequence) {
			this.sequence = sequence;
		}
		/**
		 * @return the fileName
		 */
		public String getFileName() {
			return fileName;
		}
		/**
		 * @param fileName the fileName to set
		 */
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		/**
		 * @return the extension
		 */
		public String getExtension() {
			return extension;
		}
		/**
		 * @param extension the extension to set
		 */
		public void setExtension(String extension) {
			this.extension = extension;
		}
		/**
		 * @return the cityName
		 */
		public String getCityName() {
			return cityName;
		}
		/**
		 * @param cityName the cityName to set
		 */
		public void setCityName(String cityName) {
			this.cityName = cityName;
		}
		/**
		 * @return the timestamp
		 */
		public long getTimestamp() {
			return timestamp;
		}
		/**
		 * @param timestamp the timestamp to set
		 */
		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}
		
		public void setCitySequence( String citySequece) {
			this.citySequence = citySequece;
		}
		
		/**
		 * 
		 *
		 * @version	1.0.0	2018-05-16 16:38:04	dorbae	최초생성
		 * @since 1.0.0
		 * @author dorbae(dorbae.io@gmail.com)
		 *
		 * @return
		 */
		public String getFormattingFileName() {
			return String.format( "%s%s%s", this.cityName, this.citySequence, this.extension);
		}
		
		/**
		 * 
		 *
		 * @version	1.0.0	2018-05-16 15:43:41	dorbae	최초생성
		 * @since 1.0.0
		 * @author dorbae(dorbae.io@gmail.com)
		 *
		 * @param extension
		 * @return
		 */
		private boolean isAllowedExtension( String extension) {
			for ( int ll = 0; ll < ALLOWED_EXTESION.length; ll++) {
				if ( ALLOWED_EXTESION[ ll].equalsIgnoreCase( extension))
					return true;
			}

			return false;
		
		}
		
		/**
		 * 
		 *
		 * @version	1.0.0	2018-05-16 15:53:59	dorbae	최초생성
		 * @since 1.0.0
		 * @author dorbae(dorbae.io@gmail.com)
		 *
		 * @param cityName
		 * @return
		 */
		private boolean isValidCity( String cityName) {
			// Already check null, length
			char[] codePointArray = cityName.toCharArray();
			if ( codePointArray[ 0] < 65 || codePointArray[ 0] > 90)
				return false;
			
			for ( int ll = 1; ll < codePointArray.length; ll++) {
				if ( codePointArray[ ll] < 97 || codePointArray[ ll] > 122)
					return false;
			}
			
			return true;
						
		}
		
		/**
		 * 
		 *
		 * @version	1.0.0	2018-05-16 16:00:23	dorbae	최초생성
		 * @since 1.0.0
		 * @author dorbae(dorbae.io@gmail.com)
		 *
		 * @param timestamp
		 * @return
		 * @throws IllegalArgumentException
		 */
		private long parseTimestamp( String timestamp) throws IllegalArgumentException {
			long parsedTimestamp = 0L;
			
			if ( timestamp == null)
				throw new IllegalArgumentException( "Timstamp must be not null.");
			
			try {
				parsedTimestamp = TIMESTAMP_FORMAT.parse( timestamp).getTime();
			
			} catch ( Exception e) {
				throw new IllegalArgumentException( String.format( "Invalid format timestamp data [%s].", timestamp));
		
			}
			
			if ( parsedTimestamp < minimumTimestamp || parsedTimestamp > maximumTimestamp) {
				throw new IllegalArgumentException( "Invalid timestamp.");
			}
			
			return parsedTimestamp;
			
		}
	}

}

