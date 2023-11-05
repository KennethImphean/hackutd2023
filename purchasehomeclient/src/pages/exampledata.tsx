import Image from 'next/image'
import Head from 'next/head';
import Navbar from './components/navbar';

const Exampledata = () => {
  return (
    <>
      <Head>
        <title>Home Pre-Approval Example Data</title>
        <meta name="description" content="Example Data"></meta>
      </Head>
      <h1 className="text-3xl font-bold">
        <Navbar/>
      </h1>
    </>
  )
};
export default Exampledata;
