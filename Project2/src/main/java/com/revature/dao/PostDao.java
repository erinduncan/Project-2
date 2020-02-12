package com.revature.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import com.revature.driver.Log;
import com.revature.models.Post;
import com.revature.util.HibernateUtil;

public class PostDao implements DaoContract<Post> {

	@Override
	public List<Post> findAll() {
		List<Post> list = HibernateUtil.getSessionFactory().openSession()
				.createNativeQuery("select * from posts", Post.class).list();
		Log.log.info("All posts found and returned.");
		return list;
	}

	@Override
	public Post findById(int id) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = sess.beginTransaction();
		Post post = sess.get(Post.class, id);
		tx.commit();
		Log.log.info("Post found by ID number.");
		return post;
	}

	@Override
	public Post update(Post t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post insert(Post t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		Log.log.info("New post created.");
		return t;
	}

	@Override
	public Post delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void uploadImage() {

		// This inputStream is supposed to take in the image that is uploaded
		// Probably some JS something IDK but it shouldn't be null
		InputStream inputStream = null;
		Regions clientRegion = Regions.DEFAULT_REGION;
		// This is using my bucket, don't know if access needs to be granted or not
		// May need to set up permissions in the bucket
		String bucketName = "erin-revature";
		// fileName is the path of the file to be uploaded
		String fileName = "";

		try {
			byte[] contents = IOUtils.toByteArray(inputStream);
			InputStream stream = new ByteArrayInputStream(contents);
			AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(clientRegion).build();

			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentLength(contents.length);
			meta.setContentType("image/png");

			s3client.putObject(new PutObjectRequest(bucketName, fileName, stream, meta)
					.withCannedAcl(CannedAccessControlList.Private));
		} catch (AmazonServiceException e) {
			Log.log.error(e.getMessage());
		} catch (SdkClientException e) {
			Log.log.error(e.getMessage());
		} catch (IOException e) {
			Log.log.error(e.getMessage());
		}

	}

}
